package com.lawrencemouarkach

import groovy.transform.Canonical

@Canonical
class HelloRequest {
    String name
    int age

    HelloRequest(String name, int age) {
        this.name = name
        this.age = age
    }
}
