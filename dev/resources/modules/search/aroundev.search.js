/**
 * Created by Antonin on 10/01/2015.
 */
angular.module('aroundev.search', [
    "ngAnimate" ,
    'ui.bootstrap'
])
.directive('search',function(){
    return {
        // scope: true,
        restrict:'E',
        //controller:'searchCtrl',
        //replace:true,//IMPORTANT : solution found for modified dom by link method ->
        templateUrl:'search.html'
    };
    //compile : function ..., replace : true or false
})
    //FIX Angular 1.3 bug DAtepicker date format on initialization
    //http://stackoverflow.com/questions/25742445/angularjs-1-3-datepicker-initial-format-is-incorrect
    .directive('datepickerPopup', function (dateFilter, datepickerPopupConfig) {
        return {
            restrict: 'A',
            priority: 1,
            require: 'ngModel',
            link: function(scope, element, attr, ngModel) {
                var dateFormat = attr.datepickerPopup || datepickerPopupConfig.datepickerPopup;
                ngModel.$formatters.push(function (value) {
                    return dateFilter(value, dateFormat);
                });
            }
        };
    })

    .controller('CollapseDemoCtrl', function ($scope) {
        $scope.isCollapsed = true;
    })
    .controller('beginDateCtrl', function ($scope) {
        $scope.today = function() {
            $scope.dt = new Date();
        };
        $scope.today();

        $scope.clear = function () {
            $scope.dt = null;
        };

/*        // Disable weekend selection
        $scope.disabled = function(date, mode) {
            return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
        };*/

        $scope.toggleMin = function() {
            $scope.minDate = $scope.minDate ? null : new Date();
        };
        $scope.toggleMin();

        $scope.open = function($event) {
            $event.preventDefault();
            $event.stopPropagation();

            $scope.opened = true;
        };

        $scope.dateOptions = {
            formatYear: 'yy',
            startingDay: 1
        };

        $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
        $scope.format = $scope.formats[0];
    })
    .controller('endDateCtrl', function ($scope) {
        $scope.today = function() {
            $scope.dt = new Date();
        };
        $scope.today();

        $scope.clear = function () {
            $scope.dt = null;
        };

        // Disable weekend selection
       /* $scope.disabled = function(date, mode) {
            return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
        };*/

        $scope.toggleMin = function() {
            $scope.minDate = $scope.minDate ? null : new Date();
        };
        $scope.toggleMin();

        $scope.open = function($event) {
            $event.preventDefault();
            $event.stopPropagation();

            $scope.opened = true;
        };

        $scope.dateOptions = {
            formatYear: 'yy',
            startingDay: 1
        };

        $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
        $scope.format = $scope.formats[0];
    });