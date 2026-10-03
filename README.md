# Wolf Curse - NeoForge 1.21.1

This is a Java/NeoForge source project targeting Minecraft 1.21.1 and Java 21.

## Included
- Persistent per-player curse data using NeoForge data attachments.
- A Cursed Fang item that starts the curse.
- Staged curse progress handled on the server.
- A Wolf Cure item and reusable Cleansing Charm.
- An optional Create 6.0.x `create:mixing` recipe for the Wolf Cure.
- Item textures from the supplied project where applicable.

## Build
Use Java 21 and Gradle. The project follows the NeoForge 1.21.1 NeoGradle layout.

If you have Gradle installed:

    gradle build

The finished mod jar will be in:

    build/libs/wolfcurse-1.0.0.jar

The Gradle wrapper binary is not included in this ZIP because it could not be fetched in the current build environment.

## Notes
The previous source contained client rendering and custom mount code written against newer rendering APIs. Those pieces were removed from this conversion so the project is focused on the NeoForge 1.21.1-compatible gameplay core instead of shipping known version-mismatched code.
