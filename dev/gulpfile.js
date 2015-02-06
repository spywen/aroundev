var gulp = require('gulp'),//GULP !!!
    less = require('gulp-less'),//Convert less to css
    uglify = require('gulp-uglify'),//Uglify js
    stripDebug = require('gulp-strip-debug'),//Remove console.log for the prod scripts
    plumber = require('gulp-plumber'),//Avoid bugs during gulp watch
    minifycss = require('gulp-minify-css'),//minify css
    inject = require('gulp-inject'),//Inject css/js in page
    concat = require('gulp-concat'),//Concatenation of files
    rename = require('gulp-rename'),//Renaming
    args = require('yargs').argv,//gulp arguments to parameterize gul commands
    ngAnnotate = require('gulp-ng-annotate'),//automatic angular annotations
    bowerfiles = require('main-bower-files'),//Manage bower plugins files to inject
    gulpif = require('gulp-if'),//Gulp if logic
    jshint = require('gulp-jshint'),//JS quality tools
    htmlify = require('gulp-angular-htmlify'),//add 'data-' before all angular attributes
    ngHtml2Js = require("gulp-ng-html2js"),//Cache of view
    clean = require('gulp-clean'),//Delete files and folders
    replace = require('gulp-replace-task');//Replace by regex content of files


//Location
var baseLocationPath = './resources/',
    indexLocation = baseLocationPath + 'index.jsp',
    scriptsLocation = [baseLocationPath + '**/*.js', '!' + baseLocationPath + '**/*.spec.js'],
    i18nsLocation = baseLocationPath + 'modules/i18n/json/**/*.json',
    viewsLocation = baseLocationPath + '**/*.html',
    stylesLocation = baseLocationPath + '**/*.less',
    imagesLocation = baseLocationPath + 'img/**/*';
//Destination
var baseDestinationPath = './../src/main/webapp/',
    indexDestination = baseDestinationPath + 'WEB-INF',
    scriptDestination = baseDestinationPath + 'app/js',
    pluginsDestination = baseDestinationPath + 'app/lib',
    styleDestination = baseDestinationPath + 'app/css',
    imagesDestination = baseDestinationPath + 'app/img',
    viewsDestination = baseDestinationPath + 'app/views',
    i18nsDestination = baseDestinationPath + '/app/lang';
//Args
var env = args.env || 'dev';
var minify = true;
if(env === 'dev'){
    minify = false;
}

//Style : concat + less to css + minify
gulp.task('style', function () {
    return gulp.src(stylesLocation)
        .pipe(plumber())
        .pipe(less())
        .pipe(concat('all.css'))
        .pipe(gulp.dest(styleDestination))
        .pipe(minifycss())
        .pipe(rename('all.min.css'))
        .pipe(gulp.dest(styleDestination));
});

//Views
gulp.task('view', function () {
    return gulp.src(viewsLocation)
        .pipe(htmlify())
        .pipe(rename({ dirname: '' }))
        .pipe(gulp.dest(viewsDestination));
});
gulp.task('generate-partial', function() {
    return gulp.src(viewsLocation)
        .pipe(rename({ dirname: '' }))
        .pipe(ngHtml2Js({moduleName: "aroundev.partial"}))
        .pipe(concat("partials.js"))
        .pipe(gulp.dest(viewsDestination))
        .pipe(uglify())
        .pipe(rename('partials.min.js'))
        .pipe(gulp.dest(viewsDestination));
});

//I18N files 
gulp.task('i18n', function () {
    return gulp.src(i18nsLocation)
        .pipe(rename({ dirname: '' }))
        .pipe(gulp.dest(i18nsDestination));
});

//Script
//Quality task will run before script task.
//If a quality error occured the script task will not be executed
gulp.task('script', ['quality', 'generate-partial'], function () {
    return gulp.src(scriptsLocation)
        .pipe(plumber())
        .pipe(concat('all.js'))
        .pipe(ngAnnotate())
        .pipe(gulp.dest(scriptDestination))
        .pipe(stripDebug())
        .pipe(uglify())
        .pipe(rename('all.min.js'))
        .pipe(gulp.dest(scriptDestination));
});
//Quality
gulp.task('quality', function(){
    return gulp.src(scriptsLocation)
        .pipe(jshint())
        .pipe(jshint.reporter('default'))
        .pipe(jshint.reporter('fail'));
});

// Plugins injection
gulp.task('inject' ,function () {
    gulp.src(indexLocation)
        .pipe(gulpif(minify, replace({
          patterns: [
            {
              match: /@MINIFY@/g,
              replacement: '.min.'
            }
          ]
        })))
        .pipe(gulpif(!minify, replace({
          patterns: [
            {
              match: /@MINIFY@/g,
              replacement: '.'
            }
          ]
        })))
        .pipe(inject(gulp.src(bowerfiles({ read: false, debugging: false, env: env })), { ignorePath: "/bower_components/", addPrefix: "/app/lib/", addRootSlash: true }))
        .pipe(gulp.dest(indexDestination));

    gulp.src(bowerfiles({ checkExistence: true, read: true, debugging: false, env: env }), { base: 'bower_components' })
        .pipe(gulp.dest(pluginsDestination));
});

//Images
gulp.task('image', function(){
    gulp.src(imagesLocation)
        .pipe(gulp.dest(imagesDestination));
});

//Delete files and folders inside app folder
gulp.task('clean',function(){
    return gulp.src('./../src/main/webapp/app/*', {read: false})
        .pipe(clean({force: true}));
});



/*--- command 'gulp watch' ---*/
gulp.task('watch',['style', 'script', 'view', 'i18n'] , function(){
    gulp.watch(stylesLocation, ['style']);
    gulp.watch(scriptsLocation, ['script']);
    gulp.watch(viewsLocation, ['view']);
    gulp.watch(i18nsLocation, ['i18n']);
});




//Commands :
//Parameter : gulp (--env=dev or --env=prod),
gulp.task('default', ['script', 'view', 'style', 'i18n']);
gulp.task('plugins', ['inject', 'image']);

//ALL
gulp.task('all', ['default','plugins']);