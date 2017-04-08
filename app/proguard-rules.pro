# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in E:\Android\sdk/tools/proguard/proguard-android.txt
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

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontwarn android.support.**
-verbose

-dontoptimize
-dontpreverify


-keepattributes *Annotation*
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService
-keep public class * extends android.support.v4.app.Fragment
-keep public class * extends android.app.Fragment

-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

 -keepclassmembers public class * extends android.view.View {
  void set*(***);
  *** get*();
 }

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keepclassmembers class **.R$* {
  public static <fields>;
}
-keeppackagenames org.jsoup.nodes
-keep public class org.jsoup.** {
public *;
}
-keepclassmembers class com.quang.camamsaotruc.activities.MainActivity.MyJavaScriptInterface{
   *;
}
-dontwarn com.squareup.okhttp.**

-keepattributes JavascriptInterface
-keep public class com.mypackage.MyClass$MyJavaScriptInterface
-keep public class * implements com.mypackage.MyClass$MyJavaScriptInterface
-keepclassmembers class com.mypackage.MyClass$MyJavaScriptInterface {
    <methods>;
}
-keep public class com.quang.smartcar.activities.MainActivity$MyJavaScriptInterface
-keep public class * implements com.quang.smartcar.activities.MainActivity$MyJavaScriptInterface
-keepclassmembers class com.quang.smartcar.activities.MainActivity$MyJavaScriptInterface {
    <methods>;
}
# Add this global rule
-keep class com.google.android.gms.maps.** { *; }
-keep interface com.google.android.gms.maps.** { *; }