/**
 * Created by laurent on 18/10/2014.
 */
/*https://www.youtube.com/watch?v=-Q5v14O3Bmk*/

/*--- tools ---*/
var gulp = require('gulp'),
    less = require('gulp-less'),//Convert less to css
    uglify = require('gulp-uglify'),//Uglify js
    plumber = require('gulp-plumber'),//Avoid bugs during gulp watch
    minifycss = require('gulp-minify-css'),//minify css
    inject = require('gulp-inject'),//Inject css/js in page
    concat = require('gulp-concat'),//Concat files
    rename = require('gulp-rename'),//Renaming
    args = require('yargs').argv,//gulp arguments
    ngAnnotate = require('gulp-ng-annotate'),
    bowerfiles = require('main-bower-files'),//Manage bower plugins files
    gulpif = require('gulp-if');//Gulp if


//Location
var indexLocation = "./../src/main/webapp/WEB-INF/index.jsp";
var scriptLocation = ['js/**/*.js'];
var otherFilesLocation = ['js/**/*.html', 'js/**/*.json'];
var styleLocation = ['css/**/*.less', 'js/**/*.less'];

//Destination
var scriptDestination = './../src/main/webapp/app/js';
var styleDestination = './../src/main/webapp/app/css';

//Args
var env = args.env  || 'prod';
var debug = args.debug || false;

//Style
gulp.task('style', function(){
    return gulp.src(styleLocation)
        .pipe(plumber())
        .pipe(concat('all.min.css'))
        .pipe(less())
        .pipe(minifycss())
        .pipe(gulp.dest(styleDestination));
});

//template
gulp.task('otherFiles', function(){
    return gulp.src(otherFilesLocation)
        .pipe(gulp.dest(scriptDestination));
});

//Script
gulp.task('script', function(){
    return gulp.src(scriptLocation)
        .pipe(plumber())
        .pipe(concat('all.min.js'))
        .pipe(ngAnnotate())
        .pipe(gulpif(!debug, uglify()))
        .pipe(gulp.dest(scriptDestination));
});

// Plugins injection. Parameter : gulp plugins --env=dev or gulp plugins --env=prod (by default PROD : gulp plugins)
gulp.task('inject', function() {
    gulp.src(indexLocation)
        .pipe(inject(gulp.src(bowerfiles({read: false, debugging : false, env : env})), { ignorePath : "/bower_components/", addPrefix : "/app/js/lib/"}))
        .pipe(gulp.dest("./../src/main/webapp/WEB-INF/"));

    gulp.src(bowerfiles({checkExistence : true, read: true, debugging : false, env : env}), {base: 'bower_components'})
        .pipe(gulp.dest("./../src/main/webapp/app/js/lib/"));
});


/*--- command 'gulp [default || plugins]' ---*/
gulp.task('default', ['script', 'otherFiles', 'style']);
gulp.task('plugins', ['inject']); //(+plugins)

/*--- command 'gulp watch' ---*/
/*gulp.task('watch', function(){
    gulp.watch(styleLocation, ['style']);
    gulp.watch(scriptLocation, ['script']);
    gulp.watch(pageLocation, ['page']);
});*/