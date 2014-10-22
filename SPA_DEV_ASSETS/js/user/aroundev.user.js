/**
 * Created by laurent on 19/10/2014.
 */
angular.module('aroundev.user', [
    'aroundev.service.auth'
]).controller('userCtrl', function($scope, authService) {
    $scope.pageClass = 'loginPageClass';

    $scope.logIn = function(){
        authService.login($scope.login, $scope.password);
    };
});