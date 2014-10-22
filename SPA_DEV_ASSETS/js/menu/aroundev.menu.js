/**
 * Created by laurent on 19/10/2014.
 */
angular.module('aroundev.menu', [
    'aroundev.service.auth'
]).controller('menuCtrl', function($scope, authService) {
    $scope.logOut = function(){
        authService.logout();
    };
});