/**
 * Created by laurent on 18/10/2014.
 */
angular.module('aroundev', [
    'ngAnimate',
    'ui.bootstrap',
    'aroundev.translate',
    'aroundev.menu',
    'aroundev.index',
    'aroundev.user.login',
    'aroundev.service.auth'
])
.config(function($translateProvider, $locationProvider){
    $locationProvider.html5Mode(true);//Remove the '#' on the url
})
.value('user', null)
.constant('configs', {
    defaultLanguage: '"en"',
    translateAllowed: false
})
.constant('roles', {
    authenticated:'AUTHENTICATED',
    admin:'ADMIN',
    user:'USER'
})
.run(function(authService, $location, $rootScope, $state, roles){
    authService.getProfile().then(function(result){
        $rootScope.$broadcast('user:logged', result);
    },function(){
        console.log('Person not connected');
    });

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
