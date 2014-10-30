/**
 * Created by laurent on 18/10/2014.
 */
'use strict';

angular.module('aroundev', [
    'ngAnimate'
    ,'aroundev.translate'
    ,'aroundev.menu'
    ,'aroundev.index'
    ,'aroundev.user.login'
    ,'aroundev.service.security'
    ,'ngRoute'
    ,'ui.bootstrap'
])
.config(function($translateProvider, $locationProvider, $routeProvider){
    //Routing
    $routeProvider.otherwise({redirectTo: '/'});

    //Location
    $locationProvider.html5Mode(true);//Remove the '#' on the url

    //Translate
    $translateProvider.useStaticFilesLoader({
        prefix: '/app/js/modules/languages/json/',
        suffix: '.json'
    });
    $translateProvider.useCookieStorage();
    $translateProvider.preferredLanguage('en');
})
.value('user', {value: ''})
.run(function(authService, securityService, $location, $rootScope){
    authService.getProfil().then(function(result){
        $rootScope.$emit ('user:logged', result);
        if(!securityService.hasRole('AUTHENTICATED')){
            $location.path('/login');
        }
    },function(){
        console.log('Person not connected');
    });
});