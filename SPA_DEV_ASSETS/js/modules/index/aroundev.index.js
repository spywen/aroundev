/**
 * Created by laurent on 19/10/2014.
 */
angular.module('aroundev.index', [
    'ui.router'
])
.config(function($stateProvider, $urlRouterProvider){
    $stateProvider.state('index', {
        url: '/',
        templateUrl: '/app/js/modules/index/view/index.html',
        controller: 'indexCtrl',
        authenticate: false
    });
})
.controller('indexCtrl', function($scope) {
    $scope.pageClass = 'indexPageClass';
});