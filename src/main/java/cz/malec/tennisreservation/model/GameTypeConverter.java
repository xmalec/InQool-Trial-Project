/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.malec.tennisreservation.model;

import cz.malec.tennisreservation.model.GameType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author JiříMalec
 */
@Converter
public class GameTypeConverter implements AttributeConverter<GameType , Integer> {

    @Override
    public Integer convertToDatabaseColumn(GameType gameType) {
        if(gameType == null) {
            return null;
        }
        return gameType.getValue();
    }

    @Override
    public GameType convertToEntityAttribute(Integer ack) {
        if(ack == null) {
            return null;
        }
        return GameType.get(ack);
    }


}