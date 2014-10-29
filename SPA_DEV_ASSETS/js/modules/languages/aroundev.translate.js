/**
 * Created by laurent on 18/10/2014.
 */
angular.module('aroundev.translate', [
    'aroundev.service.auth',
    'pascalprecht.translate',
    'ngCookies'
]).controller('translateCtrl', function($scope, $translate, $cookies) {
    $scope.en = false;
    $scope.fr = false;
    var currentLanguage = $cookies.NG_TRANSLATE_LANG_KEY;
    if(currentLanguage === '"en"'){
        $scope.en = true;
    }else if(currentLanguage === '"fr"'){
        $scope.fr = true;
    }else{
        $scope.en = true;
    }
    $scope.changeLanguage = function (langKey){
        $translate.use(langKey);
        $scope.en = false;
        $scope.fr = false;
        if(langKey === 'en'){
            $scope.en = true;
        }else if(langKey === 'fr'){
            $scope.fr = true;
        }else{
            $scope.en = true;
        }
    };
});