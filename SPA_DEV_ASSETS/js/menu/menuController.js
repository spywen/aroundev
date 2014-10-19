/**
 * Created by laurent on 19/10/2014.
 */
aroundevApp.controller('menuCtrl', function($scope, authService) {
    $scope.logOut = function(){
        authService.logout();
    };
});