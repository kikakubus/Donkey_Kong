module Donkey.Kong {
    requires hanyaeger;



    exports org.example;
    exports org.example.scenes;
    exports org.example.entities.level;
    exports org.example.entities.level.ladders;
    exports org.example.entities.powerups;

    opens Backgrounds;
    opens Sound;
    opens sprites;
    exports org.example.Hitbox;
}