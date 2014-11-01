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
.run(function(authService, $location, $rootScope, $state){
    authService.getProfile().then(function(result){
        $rootScope.$broadcast('user:logged', result);
    },function(){
        console.log('Person not connected');
    });

    $rootScope.$on("$stateChangeStart", function(event, toState, toParams, fromState, fromParams){
        if (toState.authenticate){
            authService.isAuthenticated().then(function(result){
                if(!result){
                    // User isn’t authenticated
                    $state.transitionTo("login");
                    event.preventDefault();
                }
            },function(){});
        }
    });
});
