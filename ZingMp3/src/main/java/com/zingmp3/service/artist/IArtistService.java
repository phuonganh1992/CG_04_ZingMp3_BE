package com.zingmp3.service.artist;

import com.zingmp3.model.Artist;
import com.zingmp3.service.IGeneralService;

public interface IArtistService extends IGeneralService<Artist> {
    Artist findByName(String name);
}
