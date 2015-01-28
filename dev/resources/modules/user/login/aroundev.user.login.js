/**
 * Created by laurent on 19/10/2014.
 */
angular.module('aroundev.user.login', [
    'aroundev.service.auth',
    'pascalprecht.translate',
    'ui.router',
    'toastr'
])
.config(function($stateProvider, $urlRouterProvider){
    $stateProvider.state('login', {
        url:'/login',
        templateUrl: 'login.html',
        controller: 'loginCtrl',
        hasRoles:[],
        hasNotRoles:['AUTHENTICATED']
    });
})
.constant('localConfig', { connexionLatence : 1000 })
.controller('loginCtrl', function($translate, $scope, authService, $interval, $location, $rootScope, localConfig, toastr, $state) {

    //Variable to manage $interval functionnality
    $scope.chrono = undefined;

    $scope.pageClass = 'loginPageClass';

    $scope.logIn = function(){
        $scope.progressBarLogin = true;
        $scope.progressBarValue = 20;

        $scope.chrono = $interval(function(){
            authService.login($scope.login, $scope.password).then(function(result){
                $scope.progressBarValue = 60;
                authService.getProfile().then(function(profile){
                    $scope.loginSuccess(profile);
                }, function(error){
                    $scope.loginFailed();
                });
            }, function(error){
                $scope.loginFailed();
            });
        }, localConfig.connexionLatence, 1);
    };

    $scope.resetProgressBar = function(){
        $scope.progressBarLogin = false;
        $scope.progressBarValue = 0;
        $scope.progressBarType = '';
    };

    $scope.loginCtrlFieldsUpdated = function(){
        $interval.cancel($scope.chrono);
        $scope.resetProgressBar();
    };

    $scope.loginFailed = function(){
        toastr.error($translate.instant('LOGIN_LOG_IN_FAILED'));
        $scope.progressBarValue = 100;
        $scope.progressBarType = 'progress-bar-danger';
        $scope.chrono = $interval(function(){
            return $scope.resetProgressBar();
        }, 4000, 1);
    };

    $scope.loginSuccess = function(profile){
        $scope.progressBarValue = 100;
        $scope.progressBarType = 'progress-bar-success';
        $scope.chrono = $interval(function(){
            toastr.success($translate.instant('LOGIN_LOG_IN_SUCCESS'));
            $rootScope.$emit ('user:logged', profile);
            $state.transitionTo("index");
            $scope.resetProgressBar();
        }, localConfig.connexionLatence, 1);
    };
});

