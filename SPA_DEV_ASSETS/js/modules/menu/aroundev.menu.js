/**
 * Created by laurent on 19/10/2014.
 */
angular.module('aroundev.menu', [
    'aroundev.service.auth'
]).controller('menuCtrl', function($scope, authService, $rootScope) {
    $scope.logged = false;

    $rootScope.$on ('user:logged', function (event, profil) {
        $scope.logged = true;
        $scope.username = profil.login;
    });

    $scope.logOut = function(){
        authService.logout();
    };
});