# Only A View Has Keydown Events

We can only override the `onKeyDown` method from an android view so the code can only be hooked from MainActivity.

## Getting JS module before react instance is fully setup

The event emitter module is not available before the react instance can be fully initialised and will throw an error. Currently there is no way to add a listener to an 'initialized' event so it is up to us to check before calling any APIs.

