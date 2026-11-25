{
  description = "Nibblosaur development environment";

  inputs.nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";

  outputs = {nixpkgs, ...}: let
    system = "x86_64-linux";
    pkgs = nixpkgs.legacyPackages.${system};

    libraries = with pkgs; [
      gtk3
      glib
      pango
      atk
      cairo
      gdk-pixbuf
      libGL
      libglvnd
      libX11
      libXtst
      libXxf86vm
    ];
  in {
    devShells.${system}.default = pkgs.mkShell {
      packages = with pkgs; [
        jdk25
        maven
      ];

      LD_LIBRARY_PATH = pkgs.lib.makeLibraryPath libraries;
    };
  };
}
