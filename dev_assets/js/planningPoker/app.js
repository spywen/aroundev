/**
 * Created by laurent on 26/07/2014.
 */
var myPlanningPokerApp = angular.module('planningPoker', ['ui.bootstrap']);

myPlanningPokerApp.controller('listMyGrooming', ['$scope', '$http', function ($scope, $http) {
    $scope.oneAtATime = true;
    $scope.groomings = [];

    $http({
        method: 'GET',
        url: '/api/planningpoker/grooming'
    })
    .success(function (data, status, headers, config) {npm
        $scope.groomings = data;
    })
    .error(function (data, status, headers, config) {
    });

    $scope.newGroomingForm = function(){
        var data = $scope.fields;
        $http.post()

    }
}]);