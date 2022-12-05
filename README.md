## MimosaComputers

This is the source for a Minecraft 1.19.2 mod that is heavily inspired by [OpenComputers](https://github.com/MightyPirates/OpenComputers),
a Minecraft 1.7.10 & 1.12.2 (also with 1.16.5 in development) mod that adds computers that can be programmed via the Lua programming language.

*WARNING!* This mod is still in its early stages of development! This means there may be security flaws, bugs or crashes.
This mod is *NOT* suitable for a production environment.  
I would be thankful if someone were to test it for me, but please do not blame me when your server crashes or you find that the mod is buggy.  
If you do find a bug, please report it on the "issues" page of this repository.

The major upgrades and changes from OpenComputers that are done, in progress, or planned are:
* The mod is on version 1.19.2, with the Fabric modloader (with possible, but unlikely Forge version)
* Use LuaJIT instead of Lua (for faster execution of complex Lua programs) (in progress)
* Include better graphics functionality by default, so players don't have to implement basic 
things like the rendering of triangles themselves. (planned)

I am accepting `feature` marked issues, I'd love to see what the community can add to this mod.

However, please keep it reasonable. I will remove joke issues, nonsensical issues, or otherwise useless issues.  
I am also not going to be adding every suggestion, they have to be feasible and not ruin the feel of the mod.

## Install Instructions
* First, install JDK version 17.0.1 and Gradle (any version).  
* Then, clone this repository either via Git or via pressing the "code"
button in the upper right of the GitHub page,
then pressing "download as ZIP", then extracting it to a drive with at least 300 MB of space.   
* Then, run the command `gradle build` in the directory with the file `build.gradle` within it.  
This should produce a folder in that directory labeled "build". Go into that folder, then go into
the `libs` folder within that. There should be a file labeled `mimosa_computers-(version).jar`.  
Copy that into your `mods` folder.
* Then, go to the repository [OpenComputers-Rust-LuaJIT](https://github.com/ThatCodingGuy86/MimosaComputers-Rust-LuaJIT), and follow the instructions there.

After that, you have installed and can run the MimosaComputers mod.  
Don't worry, this will get easier once this is more developed, I can't be bothered to set  
up GitHub Releases right now, as the mod itself doesn't fully work properly. Which I would say is more important than ease of install.