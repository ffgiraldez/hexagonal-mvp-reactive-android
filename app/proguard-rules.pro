# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/thanerian/develop/libraries/android/android-sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Dagger configuration

-dontwarn dagger.internal.codegen.**
-keepclassmembers,allowobfuscation class * {
    @javax.inject.* *;
    @dagger.* *;
    <init>();
}
-keep class dagger.* { *; }
-keep class javax.inject.* { *; }
-keep class * extends dagger.internal.Binding
-keep class * extends dagger.internal.ModuleAdapter
-keep class * extends dagger.internal.StaticInjection

# ButterKnife

-dontwarn butterknife.internal.**
-keep class **$$ViewInjector { *; }
-keepnames class * { @butterknife.InjectView *;}

# Rx
-dontwarn rx.**

# Picasso
-dontwarn com.squareup.okhttp.**

#okhttp

-dontwarn com.squareup.okhttp.internal.http.*
-dontwarn java.nio.file.*
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement

# Retrofit
-dontwarn retrofit.appengine.UrlFetchClient
-keepattributes *Annotation*
-keep class retrofit.** { *; }
-keepclasseswithmembers class * {
    @retrofit.http.* <methods>;
}
-keepattributes Signature

#retrolambda
-dontwarn java.lang.invoke.*

# OrmLite uses reflection
-keep class es.ffgiraldez.hmr.books.Book { *;}
