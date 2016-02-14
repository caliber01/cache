/**
 * Created by Max on 01.02.2016.
 */
angular.module('db')
    .config(function($stateProvider, $httpProvider) {
        $httpProvider.defaults.useXDomain = true;
        $httpProvider.defaults.withCredentials = true;

        $stateProvider
            .state('register', {
                url: '/register',
                templateUrl: 'states/register.html'
            })
            .state('login', {
                url: '/login',
                templateUrl: 'states/login.html'
            })
            .state('dashboard', {
                url: '/dashboard',
                templateUrl: 'states/dashboard.html'
            })
            .state('project', {
                url: '/projects/:id',
                templateUrl: 'states/project.html'
            })
            .state('project.document', {
                url: '/projects/:id/document',
                templateUrl: 'templates/document.html'
            })
            .state('project.useCase', {
                url: '/projects/:id/use-case',
                templateUrl: 'templates/use-case.html'
            })
            .state('project.objectRelations', {
                url: '/projects/:id/object-relations',
                templateUrl: 'templates/object-relations.html'
            })
            .state('project.er', {
                url: '/projects/:id/er',
                templateUrl: 'templates/er.html'
            })
            .state('project.informationalRequirements', {
                url: '/projects/:id/informational-requirements',
                templateUrl: 'templates/informational-requirements.html'
            })
            .state('project.statistics', {
                url: '/projects/:id/statistics',
                templateUrl: 'templates/statistics.html'
            })
            .state('project.reports', {
                url: '/projects/:id/reports',
                templateUrl: 'templates/reports.html'
            })
            .state('project.algorithmicDependencies', {
                url: '/projects/:id/algorithmic-dependencies',
                templateUrl: 'templates/algorithmic-dependencies.html'
            })
            .state('project.integrityConstraints', {
                url: '/projects/:id/integrityConstraints',
                templateUrl: 'templates/integrity-constraints.html'
            });
    });