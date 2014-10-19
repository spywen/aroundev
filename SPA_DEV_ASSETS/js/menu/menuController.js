/**
 * Created by laurent on 19/10/2014.
 */
'use strict';

aroundevApp.controller('menuCtrl', function($scope, $translate, $http, $location) {
    $scope.logOut = function(){
        $http.get('logout')
            .success(function(data, status, headers, config){
                toastr.success($translate.instant('LOGIN_LOG_OUT_SUCCESS'));
                window.location.reload();
            }).error(function(data, status, headers, config){
                toastr.error($translate.instant('LOGIN_LOG_OUT_FAILED'));
            });
    };
});