/**
 * Created by laurent on 06/07/2014.
 */
/*https://www.youtube.com/watch?v=-Q5v14O3Bmk*/

/*--- tools ---*/
var gulp = require('gulp'),
    less = require('gulp-less'),
    useref = require('gulp-useref'),
    filter = require('gulp-filter'),
    uglify = require('gulp-uglify'),
    plumber = require('gulp-plumber'),
    minifycss = require('gulp-minify-css');

var jsFilter = filter('**/*.js');
var cssFilter = filter('**/*.css');


/*--- command gulp ---*/
gulp.task('default', ['style', 'dynamic', 'pages'], function() {
    return gulp.src('./../src/main/webapp/WEB-INF/pages/*.jsp')
        .pipe(useref.assets())
        .pipe(useref.restore())
        .pipe(useref())
        .pipe(gulp.dest('./../src/main/webapp/WEB-INF/pages'));
    //TODO : finish the build css task
});

/*--- command gulp watch ---*/
gulp.task('watch', function(){
    gulp.watch('css/*.less', ['style']);
    gulp.watch('js/*.js', ['dynamic']);
    gulp.watch('pages/*.jsp', ['default']);
});

/*--- tasks ---*/
gulp.task('style', function(){
    return gulp.src('css/*.less')
        .pipe(plumber())
        .pipe(less())
        .pipe(cssFilter)
        .pipe(minifycss())
        .pipe(cssFilter.restore())
        .pipe(gulp.dest('./../src/main/webapp/app/css'));
});
gulp.task('dynamic', function(){
    return gulp.src('js/*.js')
        .pipe(plumber())
        .pipe(jsFilter)
        .pipe(uglify())
        .pipe(jsFilter.restore())
        .pipe(gulp.dest('./../src/main/webapp/app/js'));
});
gulp.task('pages', function(){
    return gulp.src('pages/*.jsp')
        .pipe(useref.assets())
        .pipe(useref.restore())
        .pipe(useref())
        .pipe(gulp.dest('./../src/main/webapp/WEB-INF/pages'));
});