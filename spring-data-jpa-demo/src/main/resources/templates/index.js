angular.module('app', []).controller('indexController', function ($scope,$http)) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function() {
    $http.get(contextPath + '/products')
        .then(function (response)) {
        console.log(response.data)
            $scope.Products = response.data;
        });
    });
    $scope.deleteProduct = function (productId) {
    $http.delete(contextPath + '/products' + productId)
        .then(function (response)) {
        $scope.loadProducts();
        });
}



    $scope.addProductJson = function () {
        console.log($scope.newProduct);
        $http.post(contextPath + '/products', $scope.newProduct)
                .then(function (response)) {
                console.log(response.data)
                    $scope.Products = response.data;
                });
    }

    $scope.filter = function () {
    $http({
    url: contextPath + '/products/price',
    method: 'get',
    params: {
            min: $scope.filter.min,
            max: $scope.filter.max
    }
    }).then(function (response)) {
        $scope.Products = response.data;
    });
    }

    $scope.currentPage = function() {
    if ($scope.filter.min === null && $scope.filter.max === null){
    } else {
        $scope.filter();
    }
    }
    $scope.fillTable = function (page = 1) {
        $http({
            method: 'get',
            url: contextPath + '',
            params: {
            name_part: $scope.filter ? $scope.filter.name_part : null,
            min_price: $scope.filter ? $scope.filter.min_price : null,
            max_price: $scope.filter ? $scope.filter.max_price : null,
            p:page
            }
        }).then (function (response)) {
            $scope.ProductsPage = response.data;
            $scopePage.Array = $scope.generatePages(1, $scope.ProductsPage.totalPages);
        });
    }

    $scope.loadProducts();
    });