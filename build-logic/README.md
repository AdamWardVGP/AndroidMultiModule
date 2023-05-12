Build Conventions
==================

To make project module configuration easier this module will house custom gradle plugins to
configure shared dependency sets and project defaults to reduce build configuration duplication
between projects.

Additionally we define a dependency catalog to keep dependency versions synced.

Plugins package is setup into two packages:
util - Are small configuration sets intended to be building blocks and used together composite -
Combines sets of util functions applied within itself as a single plugin intended to be included in
the final application or library project

# Attribution

Reference and inspiration
from ![Now in Android](https://github.com/android/nowinandroid/tree/main/build-logic "Now in Android")