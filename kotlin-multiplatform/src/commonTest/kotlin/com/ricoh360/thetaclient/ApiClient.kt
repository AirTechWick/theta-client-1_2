package com.ricoh360.thetaclient

import io.ktor.client.HttpClient

/**
 * Return default HttpClient for unit test.
 *
 * Return mock HttpClient when useMock is true.
 *
 * @return HttpClient
 */
fun getHttpClient(): HttpClient {
    return if (MockApiClient.useMock) {
        MockApiClient.mockHttpClient
    } else {
        ApiClient.httpClient ?: run {
            ApiClient.newHttpClient().let { httpClient ->
                ApiClient.httpClient = httpClient
                httpClient
            }
        }
    }
}

/**
 * Return PreviewClient for getLivePreview unit test.
 *
 * Return mock PreviewClient when useMock is true.
 *
 * @return PreviewClient
 */
fun getHPreviewClient(): PreviewClient {
    return if (MockApiClient.useMock) {
        MockApiClient.mockPreviewClient
    } else {
        ApiClient.previewClient
    }
}
