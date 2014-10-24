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
            toastr.success($translate.instant('LOGIN_LOG_IN_SUCCESS'));
            $scope.progressBarValue = 60;
            var profil = authService.getProfil().then(function(result){
                $scope.progressBarValue = 100;
                $scope.progressBarType = 'progress-bar-success';
                $interval(function(){
                    return $scope.resetProgressBar();
                }, 2000, 1);
                $rootScope.$emit ('user:logged', result);
                $location.path('/');
            }, function(error){
                toastr.error($translate.instant('COMMON_ERROR'));
                $scope.progressBarType = 'progress-bar-danger';
            });
        }, function(error){
            toastr.error($translate.instant('LOGIN_LOG_IN_FAILED'));
            $scope.progressBarType = 'progress-bar-danger';
            $interval(function(){
                return $scope.resetProgressBar();
            }, 4000, 1);
        });
    };

    $scope.resetProgressBar = function(){
        $scope.progressBarLogin = false;
        $scope.progressBarValue = 0;
        $scope.progressBarType = '';
    };
});