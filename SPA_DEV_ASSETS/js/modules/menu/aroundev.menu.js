/**
 * Created by laurent on 19/10/2014.
 */
angular.module('aroundev.menu', [
    'aroundev.service.auth'
])
.controller('menuCtrl', function($scope, authService, $rootScope, $location) {

    /** EVENTS **/
    //Catch global event : user just logged
    $rootScope.$on ('user:logged', function (event, profile) {
        $scope.activeConnectedMode(profile);
    });

    /** INIT variables **/
    //Variable which indicate if we are connected
    $scope.logged = false;

    /** Methods **/
    //user connected
    $scope.activeConnectedMode = function(profile){
        $scope.logged = true;
        $scope.username = profile.username;
    };

    //Logout click event
    $scope.logOut = function(){
        authService.logout();
    };

    /* Manage the selected page indicator */
    $scope.isActive = function (viewLocation) {
        return new RegExp(viewLocation).test($location.path());
    };
})
.directive('menu',function(authService){
    return {
        scope: true,
        restrict:'E',//<=> <menu></menu> (E as Element) and are not allowed : class='menu' (C as class) or <div menu>... (A as attribute)
        controller:'menuCtrl',
        replace:true,//IMPORTANT : solution found for modified dom by link method ->
        templateUrl:'/app/js/modules/menu/view/menu.html',
        link:function(scope, element, attrs){
            var user = authService.getUser();
            if(user){
                scope.activeConnectedMode(user);
            }
        }
        //compile : function ..., replace : true or false
    };
});