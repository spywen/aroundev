/* TESTS ANGULAR */
var myApp = angular.module('angularTests', []);

//TODO Configs : view injection
/*myApp.config(['$routeProvider', function ($routeProvider){
    $routeProvider
        .when('/', {
            templateUrl: 'views/main.html'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);*/

//Controller : manage a specific part
myApp.controller('MainCtrl', ['$scope', 'adMath', function ($scope, adMath) {
    var test = adMath.multiplyLess2(2, 2);
    $scope.text = 'Hello, Angular fanatic ! the service result is : ' + test;
}]);
myApp.controller('ngRepeatCtrl', ['$scope', function ($scope) {
    $scope.numbers = [10, 25, 35, 45, 60, 80, 100];
    $scope.lowerBound = 42;
    // Does the Filters
    $scope.greaterThanNum = function (item) {
        return item > $scope.lowerBound;
    };
}]);
myApp.controller('bindingCtrl', ['$scope', function($scope){
    $scope.myName = '';
}]);
myApp.controller('webServiceCtrl', ['$scope', '$http', function($scope, $http){
    $scope.users = [];
    $scope.pseudoStringSearch = {};
    $scope.queryBy = '$';

    /*$scope.$watch('pseudoStringSearch', function(){
        //test
    });*/

    $http({
        method: 'GET',
        url: '/api/user'
    })
    .success(function (data, status, headers, config) {
        // données récupérées avec succès
        $scope.users = data;
    })
    .error(function (data, status, headers, config) {
        // erreur de récupération :(
    });

    $scope.delete = function (index){
      $scope.users.splice(index, 1);
    };
}]);
myApp.controller('docSourceCtrl', ['$scope', function($scope){
    $scope.docs = [
        {
            name:'vfsvp.fr',
            url:'http://vfsvp.fr/article/apprendre-angular-en-un-jour-le-guide-ultime/'
        },
        {
            name:'angular-tips.com',
            url:'http://angular-tips.com/blog/2013/08/watch-how-the-apply-runs-a-digest/'
        },
        {
            name:'angular date',
            url: 'https://docs.angularjs.org/api/ng/filter/date'
        }
    ];
}]);

//Directives : manage templates
myApp.directive('adOkBtn', function(){
    return {
        restrict: 'A',
        replace: true,
        template: '<a href="" class="adOkBtn btn btn-primary btn-sm">' +
            '<i class="fa fa-send"></i> Ok' +
            '</a>',
        link: function(scope, element, attrs){

        }
    };
});
myApp.directive('adCancelBtn', function(){
    return {
        restrict: 'A',
        replace: true,
        template: '<a href="" class="adCancelBtn btn btn-default btn-sm">' +
            '<i class="fa fa-reply"></i> Annuler' +
            '</a>',
        link: function(scope, element, attrs){

        }
    };
});

//Services : business methods
myApp.service('adMath', function () {
    this.multiplyLess2 = function (x, y) {
        return x * y - 2;
    };
});

//Factories : filters
myApp.filter('reverse', function(){
   return function (input, uppercase){
       var out = '';
       for(var i = 0; i < input.length; i++){
           out = input.charAt(i) + out;
       }
       if(uppercase){
           out = out.toUpperCase();
       }
       return out;
   };
});


