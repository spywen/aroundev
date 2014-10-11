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

//Location
var scriptLocation = ['js/*.js','js/planningPoker/*.js', 'js/multilingual/*.js'],
    styleLocation = ['css/*.less', 'css/**/*.less','!css/plugins/*.*'],
    languagesLocation = ['languages/**/*.json'],
    pageLocation = ['pages/**/*.jsp'],
    pluginScriptLocation = [//keep like this because the order is important
        'js/plugins/bootstrap.js',
        'js/plugins/angular.js',
        'js/plugins/angular-cookies.js',
        'js/plugins/angular-translate.js',
        'js/plugins/angular-translate-loader-url.js',
        'js/plugins/angular-translate-loader-static-files.js',
        'js/plugins/angular-translate-storage-cookie.js',
        'js/plugins/ui-bootstrap.js',
        'js/plugins/lodash.js',
        'js/plugins/restangular.js'
    ],
    pluginStyleLocation = ['css/plugins/*.less', 'css/plugins/*.css'];
//Destination
var scriptDestination = './../src/main/webapp/app/js',
    styleDestination = './../src/main/webapp/app/css',
    languagesDestination = './../src/main/webapp/app/languages',
    pageDestination = './../src/main/webapp/WEB-INF/pages';

//INFOS : put an '!' to exclude a path from the list

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
        //.pipe(ngmin())
        //.pipe(uglify())
        .pipe(gulp.dest(scriptDestination));
});
gulp.task('languages', function(){
   return gulp.src(languagesLocation)
       .pipe(gulp.dest(languagesDestination));
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
        .pipe(concat('plugins.all.min.css'))
        .pipe(less())
        .pipe(minifycss())
        .pipe(gulp.dest(styleDestination));
});




/*--- command 'gulp [default || plugins]' ---*/
gulp.task('default', ['style', 'script', 'page', 'languages']);
gulp.task('plugins', ['plugin_script', 'plugin_style']); //(+plugins)

/*--- command 'gulp watch' ---*/
gulp.task('watch', function(){
    gulp.watch(styleLocation, ['style']);
    gulp.watch(scriptLocation, ['script']);
    gulp.watch(pageLocation, ['page']);
});