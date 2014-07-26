/**
 * Created by laurent on 06/07/2014.
 */
/*https://www.youtube.com/watch?v=-Q5v14O3Bmk*/

/*--- tools ---*/
var gulp = require('gulp'),
    less = require('gulp-less'),
    useref = require('gulp-useref'),
    uglify = require('gulp-uglify'),
    plumber = require('gulp-plumber'),//Avoid bugs during gulp watch
    minifycss = require('gulp-minify-css'),
    inject = require('gulp-inject'),
    ngmin = require('gulp-ngmin'),
    concat = require('gulp-concat'),
    rename = require('gulp-rename');

//Location (we can put an '!' to exclude a path from the list)
var scriptLocation = ['js/*.js','js/planningPoker/*.js'],
    pluginScriptLocation = ['js/plugins/jquery.js', 'js/plugins/bootstrap.js', 'js/plugins/angular.js'],
    styleLocation = ['css/*.less'],
    pluginStyleLocation = ['css/plugins/*.less'],
    pageLocation = ['pages/**/*.jsp'];

//Destination
var scriptDestination = './../src/main/webapp/app/js',
    styleDestination = './../src/main/webapp/app/css',
    pageDestination = './../src/main/webapp/WEB-INF/pages';

/*--- tasks aroundev production ---*/
gulp.task('style', function(){
    return gulp.src(styleLocation)
        .pipe(plumber())
        .pipe(concat('app.min.css'))
        .pipe(less())
        .pipe(minifycss())
        .pipe(gulp.dest(styleDestination));
});
gulp.task('script', function(){
    return gulp.src(scriptLocation)
        .pipe(plumber())
        .pipe(concat('app.min.js'))
        .pipe(ngmin())
        .pipe(uglify())
        .pipe(gulp.dest(scriptDestination));
});
gulp.task('page', function(){
    return gulp.src(pageLocation)
        .pipe(useref.assets())
        .pipe(useref.restore())
        .pipe(useref())
        .pipe(gulp.dest(pageDestination));
});

/* tasks plugins production */
gulp.task('plugin_script', function(){
    return gulp.src(pluginScriptLocation)
        .pipe(plumber())
        .pipe(concat('plugins.all.min.js'))
        .pipe(ngmin())
        .pipe(uglify())
        .pipe(gulp.dest(scriptDestination));
});
gulp.task('plugin_style', function(){
    return gulp.src(pluginStyleLocation)
        .pipe(plumber())
        .pipe(concat('plugins.app.min.css'))
        .pipe(less())
        .pipe(minifycss())
        .pipe(gulp.dest(styleDestination));
});

//Task injection



/*--- command 'gulp' ---*/
gulp.task('default', ['style', 'script', 'page']);
//gulp.task('default', ['plugin_script', 'plugin_style']); //(+plugins)

/*--- command 'gulp watch' ---*/
gulp.task('watch', function(){
    gulp.watch(styleLocation, ['style']);
    gulp.watch(scriptLocation, ['script']);
    gulp.watch(pageLocation, ['page']);
});