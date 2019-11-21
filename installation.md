### Requirements (Android Studio Virtualization)
 - CPU which supports either [VT-x or AMD-V](https://en.wikipedia.org/wiki/X86_virtualization)
 	-  Note for Ryzen CPU users: As of 10/31/2019 current Windows drivers do not support Android virtualization, the only way to run the app on a Ryzen series CPU at this time is to use Android Studio for Linux.
 - At least 8gb of RAM, 16gb preferred 
 
 
 ### Installation instructions
 - Install [Android Studio](https://developer.android.com/studio/) version 3.5.2 or greater.
	
 - Open Android Studio select `Tools` then `AVD Manager` then install a Nexus 5X image with Android Q (API 29 x86)  
 - Clone the repository to `C:\Users\<username>\AndroidStudioProjects`  
 - Open the directory `Budget-Minimalism/BM` in Android Studio.
 - Click `Files` then `Sync Project With Gradle Files`
 - Click `Build` then `Make Project`
 - Finally click `Run` then `Run app`
