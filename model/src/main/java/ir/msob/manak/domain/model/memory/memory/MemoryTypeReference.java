package ir.msob.manak.domain.model.memory.memory;

import com.fasterxml.jackson.core.type.TypeReference;
import ir.msob.jima.core.commons.channel.ChannelMessage;
import ir.msob.jima.core.commons.channel.message.*;
import ir.msob.jima.core.commons.shared.PageResponse;
import ir.msob.manak.core.model.jima.channel.ChannelTypeReference;
import ir.msob.manak.core.model.jima.domain.DtoTypeReference;
import ir.msob.manak.core.model.jima.security.User;

import java.lang.reflect.Type;

public interface MemoryTypeReference
        extends DtoTypeReference<MemoryDto, MemoryCriteria>
        , ChannelTypeReference<MemoryDto, MemoryCriteria> {

    @Override
    default TypeReference<PageResponse<MemoryDto>> getPageResponseReferenceType() {
        return new TypeReference<PageResponse<MemoryDto>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<MemoryCriteria> getCriteriaReferenceType() {
        return new TypeReference<MemoryCriteria>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<MemoryDto> getDtoReferenceType() {
        return new TypeReference<MemoryDto>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, CriteriaMessage<String, MemoryCriteria>>> getChannelMessageCriteriaReferenceType() {
        return new TypeReference<ChannelMessage<User, CriteriaMessage<String, MemoryCriteria>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, PageableMessage<String, MemoryCriteria>>> getChannelMessagePageableReferenceType() {
        return new TypeReference<ChannelMessage<User, PageableMessage<String, MemoryCriteria>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, PageMessage<String, MemoryDto>>> getChannelMessagePageReferenceType() {
        return new TypeReference<ChannelMessage<User, PageMessage<String, MemoryDto>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, JsonPatchMessage<String, MemoryCriteria>>> getChannelMessageJsonPatchReferenceType() {
        return new TypeReference<ChannelMessage<User, JsonPatchMessage<String, MemoryCriteria>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, DtoMessage<String, MemoryDto>>> getChannelMessageDtoReferenceType() {
        return new TypeReference<ChannelMessage<User, DtoMessage<String, MemoryDto>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, DtosMessage<String, MemoryDto>>> getChannelMessageDtosReferenceType() {
        return new TypeReference<ChannelMessage<User, DtosMessage<String, MemoryDto>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }
}