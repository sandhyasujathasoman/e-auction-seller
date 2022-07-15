package com.eauction.seller.service;

/**
 * Sequence Service Interface to generate custom sequences
 *
 * @author Sandhya S S
 * @since 15/06/2022
 */
public interface SequenceService {

    Integer getNextSequence(String sequenceName);
}
