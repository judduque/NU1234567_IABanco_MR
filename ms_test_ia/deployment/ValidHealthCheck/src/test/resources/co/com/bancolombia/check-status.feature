Feature: Test created pocket success
  Background:
    * url baseUrl
    * def responseBody = read('check-status-ok-response.json')
  Scenario: Get accounts returns empty list
    Given url baseUrl + '/checkStatus'
    When method GET
    Then match responseBody == {"data":{"status":"UP","message":"The system is running"},"meta":{"code":"200","requestDateTime":"2025-06-26 13:52:26"}}|| {"data": {"status": "ERROR","message": "An error occurred while processing the request"},"meta": {"code": "500","requestDateTime": "2023-10-01 12:00:00"}}