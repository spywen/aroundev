/**
 * Created by laurent on 19/10/2014.
 */
angular.module('aroundev.user', [
    'aroundev.service.auth',
    'pascalprecht.translate',
    'ngAnimate'
]).controller('userCtrl', function($translate, $scope, authService, $interval, $location, $rootScope) {
    $scope.pageClass = 'loginPageClass';

    $scope.logIn = function(){
        $scope.progressBarLogin = true;
        $scope.progressBarValue = 20;

        authService.login($scope.login, $scope.password).then(function(result){
            $interval(function(){
                $scope.progressBarValue = 60;
                authService.getProfil().then(function(result){
                    $scope.progressBarValue = 100;
                    $scope.progressBarType = 'progress-bar-success';
                    $interval(function(){
                        toastr.success($translate.instant('LOGIN_LOG_IN_SUCCESS'));
                        $rootScope.$emit ('user:logged', result);
                        $location.path('/');
                        $interval(function(){
                            return $scope.resetProgressBar();
                        }, 500, 1);
                    }, 1000, 1);
                }, function(error){
                    toastr.error($translate.instant('COMMON_ERROR'));
                    $scope.progressBarType = 'progress-bar-danger';
                });
            }, 1000, 1);
        }, function(error){
            $interval(function(){
                toastr.error($translate.instant('LOGIN_LOG_IN_FAILED'));
                $scope.progressBarValue = 100;
                $scope.progressBarType = 'progress-bar-danger';
                $interval(function(){
                    return $scope.resetProgressBar();
                }, 4000, 1);
            }, 1000, 1);
        });
    };

    $scope.resetProgressBar = function(){
        $scope.progressBarLogin = false;
        $scope.progressBarValue = 0;
        $scope.progressBarType = '';
    };
});