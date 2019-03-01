# Initiative

General GUI test automation is diffcult and no good tool at hand.

When time comes to 2019, there are a lot of fundamental facilities allow us
to build a tool for automated GUI testing.


# Supposed Components

In order to integrate the tools into most of the automation environments, 
it should be made of parts and corss-platform.

## Engine

The core for running tests.

## Playground

The component allow GUI stuff to be happening with 'visual'.

In Linux environment we can make use of headless X 11 server 'xvfp' for 
this purpose.

When Windows or MacOS is the target platform, additional server running 
those OSes and corresponding 'remote desktop' app should be available in
xvfp environment.

