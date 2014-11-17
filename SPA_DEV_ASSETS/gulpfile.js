/**
 * Created by laurent on 18/10/2014.
 */
/*Tutoriel gulp : https://www.youtube.com/watch?v=-Q5v14O3Bmk*/

/*--- gulp tools ---*/
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
    htmlify = require('gulp-angular-htmlify'),
    image = require('gulp-image'),//ng-controller => data-ng-controller
    clean = require('gulp-clean');//Delete files and folders


//Location
var indexLocation = "./../src/main/webapp/WEB-INF/index.jsp",
    scriptsLocation = ['js/**/*.js', '!js/tests/**/*.js'],
    filesToCopyLocation = ['js/**/*.html', 'js/**/*.json'],
    stylesLocation = ['css/**/*.less', 'js/**/*.less', '!css/theme/*'],
    imagesLocation = ['img/**/*'];
//Destination
var indexDestination = "./../src/main/webapp/WEB-INF/",
    scriptsBaseDestination = './../src/main/webapp/app/js',
    pluginsScriptsDestination = "./../src/main/webapp/app/js/lib/",
    stylesBaseDestination = './../src/main/webapp/app/css',
    imagesDestination = './../src/main/webapp/app/img/';
//Args
var env = args.env  || 'prod';
var debug = args.debug || false;


//Style
gulp.task('style', function(){
    return gulp.src(stylesLocation)
        .pipe(plumber())
        .pipe(concat('all.min.css'))
        .pipe(less())
        .pipe(gulpif(!debug, minifycss()))
        .pipe(gulp.dest(stylesBaseDestination));
});
//Files to copy like html templates or traduction files
gulp.task('filesToCopy', function(){
    return gulp.src(filesToCopyLocation)
        .pipe(htmlify())
        .pipe(gulp.dest(scriptsBaseDestination));
});
//Script
//Quality task will run before script task.
//If a quality error occured the script task will not be executed
gulp.task('script', ['quality'], function(){
    return gulp.src(scriptsLocation)
        .pipe(plumber())
        .pipe(concat('all.min.js'))
        .pipe(ngAnnotate())
        .pipe(gulpif(!debug, stripDebug()))
        .pipe(gulpif(!debug, uglify()))
        .pipe(gulp.dest(scriptsBaseDestination));
});
// Plugins injection
gulp.task('inject', function() {
    gulp.src(indexLocation)
        .pipe(inject(gulp.src(bowerfiles({read: false, debugging : false, env : env})), { ignorePath : "/bower_components/", addPrefix : "/app/js/lib/"}))
        .pipe(gulp.dest(indexDestination));

    gulp.src(bowerfiles({checkExistence : true, read: true, debugging : false, env : env}), {base: 'bower_components'})
        .pipe(gulp.dest(pluginsScriptsDestination));
});
//Images
gulp.task('images', function(){
    gulp.src(imagesLocation)
        .pipe(image())
        .pipe(gulp.dest(imagesDestination));
});

//Delete files and folders inside app folder
gulp.task('clean',function(){
    return gulp.src('./../src/main/webapp/app/*', {read: false})
        .pipe(clean({force: true}));
});
//Quality
gulp.task('quality', function(){
    return gulp.src(scriptsLocation)
        .pipe(jshint())
        .pipe(jshint.reporter('default'))
        .pipe(jshint.reporter('fail'));
});

//Commands :
//Parameter : gulp (--debug=true or --debug=false),
//Remark : task executed in parallel (no order defined here)
gulp.task('default', ['script', 'filesToCopy', 'style']);
//Parameter : gulp plugins (--env=dev or --env=prod)
gulp.task('plugins', ['inject', 'images']);

//ALL
gulp.task('all', ['clean','default','plugins']);

/*--- command 'gulp watch' ---*/
/*gulp.task('watch', function(){
    gulp.watch(styleLocation, ['style']);
    gulp.watch(scriptLocation, ['script']);
    gulp.watch(pageLocation, ['page']);
});*/