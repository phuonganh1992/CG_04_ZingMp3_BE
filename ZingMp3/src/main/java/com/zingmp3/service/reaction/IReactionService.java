package com.zingmp3.service.reaction;

import com.zingmp3.model.Reaction;
import com.zingmp3.model.Song;
import com.zingmp3.service.IGeneralService;

public interface IReactionService extends IGeneralService<Reaction> {
    Iterable<Reaction> findAllBySong(Song song);
}
