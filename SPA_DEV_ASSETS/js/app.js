/**
 * Created by laurent on 18/10/2014.
 */
'use strict';

var aroundevApp = angular.module('aroundevApp', [
    'ngRoute',
    'pascalprecht.translate',
    'ngCookies'
]);

aroundevApp.config(function($routeProvider, $translateProvider, $locationProvider){
    //Routing
    $routeProvider.
        when('/', {templateUrl: '/app/js/index/html/index.html'})
        .when('/login', {templateUrl: '/app/js/user/html/login.html'});
    $locationProvider.html5Mode(true);//Remove the '#' on the url

    //Translate
    $translateProvider.useStaticFilesLoader({
        prefix: '/app/js/languages/json/',
        suffix: '.json'
    });
    $translateProvider.useCookieStorage();
    $translateProvider.preferredLanguage('en');
});