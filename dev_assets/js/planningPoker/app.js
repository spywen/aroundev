/**
 * Created by laurent on 26/07/2014.
 */
var myPlanningPokerApp = angular.module('planningPoker', [
    'ui.bootstrap',
    'restangular'
])
    .config(['RestangularProvider', function(RestangularProvider) {
        RestangularProvider.setBaseUrl('/api/planningpoker/');
    }]);

myPlanningPokerApp.controller('groomingsCtrl', ['$scope', 'Restangular', function ($scope, Restangular) {
    $scope.oneAtATime = true;
    $scope.groomings = [];

    var groomingsApi = Restangular.all('grooming');

    groomingsApi.getList().then(function(groomings) {
        $scope.groomings = groomings;
    });

    $scope.newGroomingForm = function(){
        var datas = $scope.fields;
        var newGrooming = {id:null,name:datas.name,description:datas.description,creationdate:0,enddate:null,moderator:0,isActive:true};
        groomingsApi.post(newGrooming).then(function(){
            groomingsApi.getList().then(function(groomings) {
                $scope.groomings = groomings;
            });
            datas.name = '';
            datas.description = '';
            $scope.toggle = false;
        }, function(){
            alert("error");
        });
    };

    $scope.delete = function (index){
        $scope.groomings[index].remove().then(function(){
            $scope.groomings.splice(index, 1);
        }, function(){
            alert("error");
        });
    };
}]);