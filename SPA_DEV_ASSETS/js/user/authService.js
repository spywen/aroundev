/**
 * Created by laurent on 19/10/2014.
 */
angular.module('aroundev.service.auth', [
    'pascalprecht.translate',
    'restangular'
]).config(function(RestangularProvider){
    RestangularProvider.setBaseUrl('/api/user/');
}).service('authService',function($translate, $http, $location, Restangular, $q){

    this.login = function(login,password){
        return $q(function(resolve, reject){
            var data = "login="+login+"&password="+password;
            $http.post('login', data, {
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                }
            }).
            success(function(data, status, headers, config) {
                //$location.path('/');
                //toastr.error($translate.instant(test.));
                //window.location.reload();
                resolve(true);
            }).
            error(function(data, status, headers, config){
                reject(false);
            });
        });

    };

    this.logout = function(){
        $http.get('logout')
            .success(function(data, status, headers, config){
                window.location.reload();
            }).error(function(data, status, headers, config){
                toastr.error($translate.instant('LOGIN_LOG_OUT_FAILED'));
            });
    };

    this.getProfil = function(){
        return $q(function(resolve, reject){
            Restangular.one('currentProfil').get().then(function(result){
                resolve(result);
            });
        });
    }

});