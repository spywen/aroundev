/**
 * Created by laurent on 19/10/2014.
 */
angular.module('aroundev.index', [
    'ngRoute'
])
.config(function($routeProvider){
    $routeProvider.when('/', {
        templateUrl: '/app/js/modules/index/view/index.html',
        controller: 'indexCtrl'
        //everybody allowed
    });
})
.controller('indexCtrl', function($scope) {
    $scope.pageClass = 'indexPageClass';
});