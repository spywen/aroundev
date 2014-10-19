/**
 * Created by laurent on 18/10/2014.
 */
/*Tutoriel gulp : https://www.youtube.com/watch?v=-Q5v14O3Bmk*/

/*--- gulp tools ---*/
var gulp = require('gulp'),//GULP !!!
    less = require('gulp-less'),//Convert less to css
    uglify = require('gulp-uglify'),//Uglify js
    plumber = require('gulp-plumber'),//Avoid bugs during gulp watch
    minifycss = require('gulp-minify-css'),//minify css
    inject = require('gulp-inject'),//Inject css/js in page
    concat = require('gulp-concat'),//Concatenation of files
    rename = require('gulp-rename'),//Renaming
    args = require('yargs').argv,//gulp arguments to parameterize gul commands
    ngAnnotate = require('gulp-ng-annotate'),//automatic angular annotations
    bowerfiles = require('main-bower-files'),//Manage bower plugins files to inject
    gulpif = require('gulp-if');//Gulp if logic


//Location
var indexLocation = "./../src/main/webapp/WEB-INF/index.jsp",
    scriptsLocation = ['js/**/*.js'],
    filesToCopyLocation = ['js/**/*.html', 'js/**/*.json'],
    stylesLocation = ['css/**/*.less', 'js/**/*.less'];
//Destination
var indexDestination = "./../src/main/webapp/WEB-INF/",
    scriptsBaseDestination = './../src/main/webapp/app/js',
    pluginsScriptsDestination = "./../src/main/webapp/app/js/lib/",
    stylesBaseDestination = './../src/main/webapp/app/css';
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
        .pipe(gulp.dest(scriptsBaseDestination));
});
//Script
gulp.task('script', function(){
    return gulp.src(scriptsLocation)
        .pipe(plumber())
        .pipe(concat('all.min.js'))
        .pipe(ngAnnotate())
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


//Commands :
// command : gulp (--debug=true or --debug=false)
gulp.task('default', ['script', 'filesToCopy', 'style']);
//Parameter : gulp plugins (--env=dev or --env=prod)
gulp.task('plugins', ['inject']);

/*--- command 'gulp watch' ---*/
/*gulp.task('watch', function(){
    gulp.watch(styleLocation, ['style']);
    gulp.watch(scriptLocation, ['script']);
    gulp.watch(pageLocation, ['page']);
});*/