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
    'aroundev.service.security'
])
.config(function($translateProvider, $locationProvider){
    $locationProvider.html5Mode(true);//Remove the '#' on the url
})
.value('user', {value: ''})
.value('configs', {
    defaultLanguage: '"en"',
    translateAllowed: false
})
.run(function(authService, securityService, $location, $rootScope){
    authService.getProfil().then(function(result){
        $rootScope.$broadcast('user:logged', result);
        if(!securityService.hasRole('AUTHENTICATED')){
            $location.path('/login');
        }
    },function(){
        console.log('Person not connected');
    });
});