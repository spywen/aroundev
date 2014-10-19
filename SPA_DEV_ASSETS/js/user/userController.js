/**
 * Created by laurent on 19/10/2014.
 */
aroundevApp.controller('userCtrl', function($scope, authService) {
    $scope.pageClass = 'loginPageClass';

    $scope.logIn = function(){
        authService.login($scope.login, $scope.password);
    };
});