/**
 * Created by laurent on 18/10/2014.
 */
angular.module('aroundev', [
    'ngAnimate',
    'ui.bootstrap',
    'aroundev.service.auth',
    'aroundev.translate',
    'aroundev.menu',
    'aroundev.index',
    'aroundev.user',
    'aroundev.events',
    'aroundev.test'
])
.config(function($translateProvider, $locationProvider){
    $locationProvider.html5Mode(true);//Remove the '#' on the url
})
.constant('roles', {
    authenticated:'AUTHENTICATED',
    admin:'ADMIN',
    user:'USER'
})
.run(function(authService, $location, $rootScope, $state){

    $rootScope.$on("$stateChangeStart", function(event, toState, toParams, fromState, fromParams){
        if (!_.isEmpty(toState.hasRoles)){
            authService.hasRoles(toState.hasRoles).then(function(result){
                if(!result){
                    $state.transitionTo("login");
                    event.preventDefault();
                }
            },function(){});
        }
        if (!_.isEmpty(toState.hasNotRoles)){
            authService.hasRoles(toState.hasNotRoles).then(function(result){
                if(result){
                    $state.transitionTo("index");
                    event.preventDefault();
                }
            },function(){});
        }
    });

});
