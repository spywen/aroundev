/**
 * Created by laurent on 19/10/2014.
 */
'use strict';

aroundevApp.controller('userCtrl', function($scope, $translate, $http, $location) {
    $scope.logIn = function(){
        var data = "login="+$scope.login+"&password="+$scope.password;
        $http.post('login', data, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        }).
            success(function(data, status, headers, config) {
                toastr.success($translate.instant('LOGIN_LOG_IN_SUCCESS'));
                $location.path('/');
                window.location.reload();
            }).
            error(function(data, status, headers, config){
                toastr.error($translate.instant('LOGIN_LOG_IN_FAILED'));
                $location.path('/login');
            });
    };
});