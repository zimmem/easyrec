/*
 * Copyright 2010 Research Studios Austria Forschungsgesellschaft mBH
 *
 * This file is part of easyrec.
 *
 * easyrec is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * easyrec is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with easyrec.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.easyrec.plugin.itemitem.impl;

import org.easyrec.model.core.RatingVO;
import org.easyrec.plugin.itemitem.ItemItemService;
import org.easyrec.plugin.itemitem.store.dao.ActionDAO;
import org.easyrec.plugin.itemitem.store.dao.ActionDAO.RatedTogether;
import org.easyrec.service.core.ItemAssocService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Strategy for calculating similarities between items using a pearson measure. <p/> See [Sarwar et al, 2001]. <p/>
 * [Sarwar et al, 2001] Item-based collaborative filtering recommendation algorithms. In SIAM Data Mining (WWW'01), New
 * York, NY, USA, 2001. <p/> <p> <b>Company:&nbsp;</b> SAT, Research Studios Austria </p> <p/> <p>
 * <b>Copyright:&nbsp;</b> (c) 2009 </p> <p/> <p> <b>last modified:</b><br/> $Author$<br/> $Date$<br/> $Revision$ </p>
 *
 * @author Patrick Marschik
 */
public class PearsonSimilarityCalculationStrategy extends AbstractSimilarityCalculationStrategy {
    // --------------------------- CONSTRUCTORS ---------------------------

    public PearsonSimilarityCalculationStrategy() {
        super();
    }

    public PearsonSimilarityCalculationStrategy(final ActionDAO actionDao, final ItemAssocService itemAssocService) {
        super(actionDao, itemAssocService);
    }

    // ------------------------ INTERFACE METHODS ------------------------


    // --------------------- Interface SimilarityCalculationStrategy ---------------------

    public String getSourceInfo() {
        return ItemItemService.SOURCE_INFO_PEARSON;
    }

    // -------------------------- OTHER METHODS --------------------------

    @Override
    protected double getAverage1(final RatedTogether<Integer, Integer> ratedTogether,
                                 final Map<Integer, RatingVO<Integer, Integer>> averageRatings) {
        return averageRatings.get(ratedTogether.getRating1().getItem().getItem()).getRatingValue();
    }

    @Override
    protected double getAverage2(final RatedTogether<Integer, Integer> ratedTogether,
                                 final Map<Integer, RatingVO<Integer, Integer>> averageRatings) {
        return averageRatings.get(ratedTogether.getRating2().getItem().getItem()).getRatingValue();
    }

    @Override
    protected Map<Integer, RatingVO<Integer, Integer>> getAverageItemRatings(final Integer tenantId,
                                                                                               final Integer itemTypeId) {
        final List<RatingVO<Integer, Integer>> averageItemRatings = getLatestActionDao()
                .getAverageRatingsForItem(tenantId, itemTypeId);

        final Map<Integer, RatingVO<Integer, Integer>> averageItemRatingsPerItem = new HashMap<Integer, RatingVO<Integer, Integer>>(
                averageItemRatings.size());

        for (final RatingVO<Integer, Integer> rating : averageItemRatings)
            averageItemRatingsPerItem.put(rating.getItem().getItem(), rating);

        return averageItemRatingsPerItem;
    }
}
