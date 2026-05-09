
# 🚀 Deploy Application to OpenShift using JKube

## 📌 What is JKube?

Eclipse JKube is a Maven plugin that helps you:

* Build Docker images
* Generate Kubernetes / OpenShift manifests
* Deploy directly to a Kubernetes or OpenShift cluster

It removes the need to manually write YAML files.

---

# 🏗 Prerequisites

* Java 17+ (or your project version)
* Maven installed
* OpenShift CLI (`oc`) installed
* Access to OpenShift cluster
* Docker or Podman (optional, depending on cluster setup)

---

# 📝 Step-by-Step Deployment Guide

---

## 1️⃣ Login to OpenShift Cluster

Open terminal and login:

```bash
oc login https://api.cluster-url:6443
```

Example:

```bash
oc login https://api.mycluster.example.com:6443
```

You will be prompted for:

* Username
* Password

Verify login:

```bash
oc whoami
```

Select your project/namespace:

```bash
oc project your-namespace
```

---

## 2️⃣ Add JKube Plugin to `pom.xml`

Add this inside `<build><plugins>` section:

```xml
<plugin>
    <groupId>org.eclipse.jkube</groupId>
    <artifactId>openshift-maven-plugin</artifactId>
    <version>1.15.0</version>
</plugin>
```

---

## 3️⃣ Build and Deploy Using Maven

Run this command:

```bash
mvn clean package oc:build oc:deploy
```

This will:

1. Build your application JAR
2. Create container image
3. Generate OpenShift resources
4. Deploy to OpenShift cluster

---

# 🔎 Alternative Commands

### Only Generate Resources

```bash
mvn oc:resource
```

---

### Only Build Image

```bash
mvn oc:build
```

---

### Only Deploy

```bash
mvn oc:deploy
```

---

# 📦 Verify Deployment

Check pods:

```bash
oc get pods
```

Check services:

```bash
oc get svc
```

Check routes:

```bash
oc get routes
```

---

# 🌍 Access Application

If route is created:

```bash
oc get route
```

You will get a public URL like:

```text
http://your-app-your-namespace.apps.cluster-domain.com
```

Open it in browser.

---

# 🏗 Deployment Architecture

```
Maven Build
     ↓
JKube Plugin
     ↓
OpenShift API
     ↓
BuildConfig + Deployment + Service + Route
     ↓
Running Pod
```

---

# 🔐 Notes

* Make sure you are logged in before running Maven command.
* Namespace/project must exist.
* Cluster must allow image builds (S2I or Docker strategy).

---

# 🎯 Minimal Deployment Flow

```bash
oc login https://api.cluster-url:6443
oc project your-namespace
mvn clean package oc:deploy
```

---
