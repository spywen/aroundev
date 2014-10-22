/**
 * Created by laurent on 18/10/2014.
 */
'use strict';

angular.module('aroundev', [
    'ngRoute',
    'ngAnimate',
    'aroundev.translate',
    'aroundev.menu',
    'aroundev.index',
    'aroundev.user'
]).config(function($routeProvider, $translateProvider, $locationProvider){
    //Routing
    $routeProvider.
        when('/', {
            templateUrl: '/app/js/index/html/index.html',
            controller: 'indexCtrl'
        })
        .when('/login', {
            templateUrl: '/app/js/user/html/login.html',
            controller: 'userCtrl'
        });
    $locationProvider.html5Mode(true);//Remove the '#' on the url

    //Translate
    $translateProvider.useStaticFilesLoader({
        prefix: '/app/js/languages/json/',
        suffix: '.json'
    });
    $translateProvider.useCookieStorage();
    $translateProvider.preferredLanguage('en');
});